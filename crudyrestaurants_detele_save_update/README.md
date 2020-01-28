# Java Reading CRUDy Restaurants

A student that completes this project shows that they can:

* Perform CRUD operations on an RDBMS using JPA and Hibernate (reading)
* Implement a data seeding class using JPA and Hibernate
* Explain and use Spring Data Relationships
* Use the JsonIgnoreProperties annotation to prevent infinite loops
* Use H2 Console and H2 IntelliJ integration to explore data

## Introduction

This is a basic database scheme with restaurants, menus, payment system. This Java Spring REST API application will provide endpoints for clients to read various data sets contained in the applications data.

Using the provided seed data, a successful application will return the follow data based on the given endpoint. Expand the section of the endpoint to see the data that is returned.

### Database layout

The table layouts are as follows

* Restaurant is the driving table.
* Menus have a Many-To-One relationship with Restaurant. Each Restaurant has many menus. Each menu has only one Restaurant.
* Payments have a Many-To-Many relationship with Restaurants.

![Image of Database Layout](../java-crudyrestaurant-read-db.png)

Using the provided seed data, the given endpoint will produce the stated output. Expand each endpoint to see its correct output.

<details>
<summary>http://localhost:2019/menus/menus</summary>

```JSON
[
    {
        "menuid": 4,
        "dish": "Mac and Cheese",
        "price": 6.95,
        "restaurant": {
            "restaurantid": 1,
            "name": "Apple",
            "address": "123 Main Street",
            "city": "City",
            "state": "ST",
            "telephone": "555-555-1234",
            "seatcapacity": 15,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                },
                {
                    "paymentid": 2,
                    "type": "Credit Card"
                },
                {
                    "paymentid": 3,
                    "type": "Mobile Pay"
                }
            ]
        }
    },
    {
        "menuid": 5,
        "dish": "Lasagna",
        "price": 8.5,
        "restaurant": {
            "restaurantid": 1,
            "name": "Apple",
            "address": "123 Main Street",
            "city": "City",
            "state": "ST",
            "telephone": "555-555-1234",
            "seatcapacity": 15,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                },
                {
                    "paymentid": 2,
                    "type": "Credit Card"
                },
                {
                    "paymentid": 3,
                    "type": "Mobile Pay"
                }
            ]
        }
    },
    {
        "menuid": 6,
        "dish": "Meatloaf",
        "price": 7.77,
        "restaurant": {
            "restaurantid": 1,
            "name": "Apple",
            "address": "123 Main Street",
            "city": "City",
            "state": "ST",
            "telephone": "555-555-1234",
            "seatcapacity": 15,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                },
                {
                    "paymentid": 2,
                    "type": "Credit Card"
                },
                {
                    "paymentid": 3,
                    "type": "Mobile Pay"
                }
            ]
        }
    },
    {
        "menuid": 7,
        "dish": "Tacos",
        "price": 8.49,
        "restaurant": {
            "restaurantid": 1,
            "name": "Apple",
            "address": "123 Main Street",
            "city": "City",
            "state": "ST",
            "telephone": "555-555-1234",
            "seatcapacity": 15,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                },
                {
                    "paymentid": 2,
                    "type": "Credit Card"
                },
                {
                    "paymentid": 3,
                    "type": "Mobile Pay"
                }
            ]
        }
    },
    {
        "menuid": 8,
        "dish": "Chef Salad",
        "price": 12.5,
        "restaurant": {
            "restaurantid": 1,
            "name": "Apple",
            "address": "123 Main Street",
            "city": "City",
            "state": "ST",
            "telephone": "555-555-1234",
            "seatcapacity": 15,
            "payments": [
                {
                    "paymentid": 1,
                    "type": "Cash"
                },
                {
                    "paymentid": 2,
                    "type": "Credit Card"
                },
                {
                    "paymentid": 3,
                    "type": "Mobile Pay"
                }
            ]
        }
    },
    {
        "menuid": 9,
        "dish": "Tacos",
        "price": 10.49,
        "restaurant": {
            "restaurantid": 2,
            "name": "Eagle Cafe",
            "address": "321 Uptown Drive",
            "city": "Town",
            "state": "ST",
            "telephone": "555-555-5555",
            "seatcapacity": 24,
            "payments": [
                {
                    "paymentid": 3,
                    "type": "Mobile Pay"
                }
            ]
        }
    },
    {
        "menuid": 10,
        "dish": "Barbacoa",
        "price": 12.75,
        "restaurant": {
            "restaurantid": 2,
            "name": "Eagle Cafe",
            "address": "321 Uptown Drive",
            "city": "Town",
            "state": "ST",
            "telephone": "555-555-5555",
            "seatcapacity": 24,
            "payments": [
                {
                    "paymentid": 3,
                    "type": "Mobile Pay"
                }
            ]
        }
    },
    {
        "menuid": 11,
        "dish": "Pizza",
        "price": 15.15,
        "restaurant": {
            "restaurantid": 3,
            "name": "Number 1 Eats",
            "address": "565 Side Avenue",
            "city": "Village",
            "state": "ST",
            "telephone": "555-123-1555",
            "seatcapacity": 37,
            "payments": [
                {
                    "paymentid": 2,
                    "type": "Credit Card"
                },
                {
                    "paymentid": 3,
                    "type": "Mobile Pay"
                }
            ]
        }
    }
]
```

</details>

<details>
<summary>http://localhost:2019/restaurants/restaurants</summary>

```JSON
[
    {
        "restaurantid": 1,
        "name": "Apple",
        "address": "123 Main Street",
        "city": "City",
        "state": "ST",
        "telephone": "555-555-1234",
        "seatcapacity": 15,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            },
            {
                "paymentid": 2,
                "type": "Credit Card"
            },
            {
                "paymentid": 3,
                "type": "Mobile Pay"
            }
        ],
        "menus": [
            {
                "menuid": 4,
                "dish": "Mac and Cheese",
                "price": 6.95
            },
            {
                "menuid": 5,
                "dish": "Lasagna",
                "price": 8.5
            },
            {
                "menuid": 6,
                "dish": "Meatloaf",
                "price": 7.77
            },
            {
                "menuid": 7,
                "dish": "Tacos",
                "price": 8.49
            },
            {
                "menuid": 8,
                "dish": "Chef Salad",
                "price": 12.5
            }
        ]
    },
    {
        "restaurantid": 2,
        "name": "Eagle Cafe",
        "address": "321 Uptown Drive",
        "city": "Town",
        "state": "ST",
        "telephone": "555-555-5555",
        "seatcapacity": 24,
        "payments": [
            {
                "paymentid": 3,
                "type": "Mobile Pay"
            }
        ],
        "menus": [
            {
                "menuid": 9,
                "dish": "Tacos",
                "price": 10.49
            },
            {
                "menuid": 10,
                "dish": "Barbacoa",
                "price": 12.75
            }
        ]
    },
    {
        "restaurantid": 3,
        "name": "Number 1 Eats",
        "address": "565 Side Avenue",
        "city": "Village",
        "state": "ST",
        "telephone": "555-123-1555",
        "seatcapacity": 37,
        "payments": [
            {
                "paymentid": 2,
                "type": "Credit Card"
            },
            {
                "paymentid": 3,
                "type": "Mobile Pay"
            }
        ],
        "menus": [
            {
                "menuid": 11,
                "dish": "Pizza",
                "price": 15.15
            }
        ]
    }
]
```

</details>

<details>
<summary>http://localhost:2019/restaurants/restaurant/3</summary>

```JSON
{
    "restaurantid": 3,
    "name": "Number 1 Eats",
    "address": "565 Side Avenue",
    "city": "Village",
    "state": "ST",
    "telephone": "555-123-1555",
    "seatcapacity": 37,
    "payments": [
        {
            "paymentid": 2,
            "type": "Credit Card"
        },
        {
            "paymentid": 3,
            "type": "Mobile Pay"
        }
    ],
    "menus": [
        {
            "menuid": 11,
            "dish": "Pizza",
            "price": 15.15
        }
    ]
}
```

</details>
<details>
<summary>http://localhost:2019/restaurants/restaurant/77</summary>

```JSON
{
    "timestamp": "2020-01-09T21:40:20.905+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Restaurant 77 Not Found",
    "trace": "javax.persistence.EntityNotFoundException: Restaurant 77 Not Found\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServiceImpl.lambda$findRestaurantById$0(RestaurantServiceImpl.java:50)\n\tat java.base/java.util.Optional.orElseThrow(Optional.java:408)\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServiceImpl.findRestaurantById(RestaurantServiceImpl.java:50)\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServiceImpl$$FastClassBySpringCGLIB$$d47a1bf5.invoke(<generated>)\n\tat org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:769)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\n\tat org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:353)\n\tat org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:99)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\n\tat org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:689)\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServiceImpl$$EnhancerBySpringCGLIB$$f0069608.findRestaurantById(<generated>)\n\tat com.lambdaschool.crudyrestaurants.controllers.RestaurantController.getRestaurantById(RestaurantController.java:58)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:566)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)\n\tat org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)\n\tat org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\n\tat org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)\n\tat org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)\n\tat org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\n\tat org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:634)\n\tat org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:741)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\n\tat org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96)\n\tat org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:526)\n\tat org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:139)\n\tat org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\n\tat org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\n\tat org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\n\tat org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:408)\n\tat org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:66)\n\tat org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:861)\n\tat org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1579)\n\tat org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\n\tat java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)\n\tat java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)\n\tat org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\n\tat java.base/java.lang.Thread.run(Thread.java:834)\n",
    "path": "/restaurants/restaurant/77"
}
```

</details>

<details>
<summary>http://localhost:2019/restaurants/restaurant/name/Eagle%20Cafe</summary>

```JSON
{
    "restaurantid": 2,
    "name": "Eagle Cafe",
    "address": "321 Uptown Drive",
    "city": "Town",
    "state": "ST",
    "telephone": "555-555-5555",
    "seatcapacity": 24,
    "payments": [
        {
            "paymentid": 3,
            "type": "Mobile Pay"
        }
    ],
    "menus": [
        {
            "menuid": 9,
            "dish": "Tacos",
            "price": 10.49
        },
        {
            "menuid": 10,
            "dish": "Barbacoa",
            "price": 12.75
        }
    ]
}
```

</details>

<details>
<summary>http://localhost:2019/restaurants/restaurant/state/st</summary>

```JSON
[
    {
        "restaurantid": 1,
        "name": "Apple",
        "address": "123 Main Street",
        "city": "City",
        "state": "ST",
        "telephone": "555-555-1234",
        "seatcapacity": 15,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            },
            {
                "paymentid": 2,
                "type": "Credit Card"
            },
            {
                "paymentid": 3,
                "type": "Mobile Pay"
            }
        ],
        "menus": [
            {
                "menuid": 4,
                "dish": "Mac and Cheese",
                "price": 6.95
            },
            {
                "menuid": 5,
                "dish": "Lasagna",
                "price": 8.5
            },
            {
                "menuid": 6,
                "dish": "Meatloaf",
                "price": 7.77
            },
            {
                "menuid": 7,
                "dish": "Tacos",
                "price": 8.49
            },
            {
                "menuid": 8,
                "dish": "Chef Salad",
                "price": 12.5
            }
        ]
    },
    {
        "restaurantid": 2,
        "name": "Eagle Cafe",
        "address": "321 Uptown Drive",
        "city": "Town",
        "state": "ST",
        "telephone": "555-555-5555",
        "seatcapacity": 24,
        "payments": [
            {
                "paymentid": 3,
                "type": "Mobile Pay"
            }
        ],
        "menus": [
            {
                "menuid": 9,
                "dish": "Tacos",
                "price": 10.49
            },
            {
                "menuid": 10,
                "dish": "Barbacoa",
                "price": 12.75
            }
        ]
    },
    {
        "restaurantid": 3,
        "name": "Number 1 Eats",
        "address": "565 Side Avenue",
        "city": "Village",
        "state": "ST",
        "telephone": "555-123-1555",
        "seatcapacity": 37,
        "payments": [
            {
                "paymentid": 2,
                "type": "Credit Card"
            },
            {
                "paymentid": 3,
                "type": "Mobile Pay"
            }
        ],
        "menus": [
            {
                "menuid": 11,
                "dish": "Pizza",
                "price": 15.15
            }
        ]
    }
]
```

</details>

<details>
<summary>http://localhost:2019/restaurants/restaurant/state/zz</summary>

```JSON
[]
```

</details>

<details>
<summary>http://localhost:2019/restaurants/restaurant/likename/eat</summary>

```JSON
[
    {
        "restaurantid": 3,
        "name": "Number 1 Eats",
        "address": "565 Side Avenue",
        "city": "Village",
        "state": "ST",
        "telephone": "555-123-1555",
        "seatcapacity": 37,
        "payments": [
            {
                "paymentid": 2,
                "type": "Credit Card"
            },
            {
                "paymentid": 3,
                "type": "Mobile Pay"
            }
        ],
        "menus": [
            {
                "menuid": 11,
                "dish": "Pizza",
                "price": 15.15
            }
        ]
    }
]
```

</details>

___

<details>
<summary>POST http://localhost:2019/restaurants/restaurant</summary>

DATA

```JSON
{
    "name": "Good Eats",
    "address": "123 Main Avenue",
    "city": "Uptown",
    "state": "ST",
    "telephone": "555-777-7777",
    "menus": [
        {
            "dish": "Soda",
            "price": 3.50
        },
        {
            "dish": "Latte",
            "price": 5.00
        }
    ],
    "payments": [
        {
            "paymentid":2
        },
        {
            "paymentid":3
        }
    ]
}
```

OUTPUT

```TEXT
No Body

Location Header: http://localhost:2019/restaurants/restaurant/145

Status: 201 Created
```

</details>

<details>
<summary>PUT http://localhost:2019/restaurants/restaurant/13</summary>

DATA

```JSON
{
    "payments": [
        {
            "paymentid": 2,
            "type": "Credit Card"
        }
    ],
    "restaurantid": 13,
    "name": "Java's New Restaurant",
    "address": "565 Side Avenue",
    "city": "Village",
    "state": "ZZ",
    "telephone": "555-123-4321",
    "seatcapacity": 25,
    "menus": [
        {
            "menuid": 13,
            "dish": "Sandwich",
            "price": 15.15
        },
        {
            "dish": "Hot Dish",
            "price": 17.17
        }
    ]
}
```

OUTPUT

```TEXT
No Body

Status 200 OK
```

</details>

<details>
<summary>PUT http://localhost:2019/restaurants/restaurant/777</summary>

DATA

```JSON
{
    "name": "My Favorite Cafe",
    "address": "123 Main Avenue",
    "city": "Uptown",
    "state": "ST",
    "telephone": "555-172-1727",
    "menus": [
        {
            "dish": "Soda",
            "price": 3.50
        },
        {
            "dish": "Latte",
            "price": 5.00
        }
    ],
    "payments": [
        {
            "paymentid":2
        },
        {
            "paymentid":3
        }
    ]
}

```

OUTPUT

```JSON
{
    "timestamp": "2020-01-28T21:34:40.882+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Restaurant 777 Not Found",
    "trace": "javax.persistence.EntityNotFoundException: Restaurant 777 Not Found\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServiceImpl.lambda$save$1(RestaurantServiceImpl.java:113)\n\tat java.base/java.util.Optional.orElseThrow(Optional.java:408)\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServiceImpl.save(RestaurantServiceImpl.java:113)\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServiceImpl$$FastClassBySpringCGLIB$$d47a1bf5.invoke(<generated>)\n\tat org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:769)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\n\tat org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:353)\n\tat org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:99)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\n\tat org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:689)\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServiceImpl$$EnhancerBySpringCGLIB$$a042fe30.save(<generated>)\n\tat com.lambdaschool.crudyrestaurants.controllers.RestaurantController.updateFullRestaurant(RestaurantController.java:175)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:566)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)\n\tat org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)\n\tat org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\n\tat org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)\n\tat org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)\n\tat org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\n\tat org.springframework.web.servlet.FrameworkServlet.doPut(FrameworkServlet.java:920)\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:663)\n\tat org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:741)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\n\tat org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96)\n\tat org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:526)\n\tat org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:139)\n\tat org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\n\tat org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\n\tat org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\n\tat org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:408)\n\tat org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:66)\n\tat org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:861)\n\tat org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1579)\n\tat org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\n\tat java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)\n\tat java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)\n\tat org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\n\tat java.base/java.lang.Thread.run(Thread.java:834)\n",
    "path": "/restaurants/restaurant/777"
}

Status 500 Internal Server Error
```

</details>

<details>
<summary>PATCH http://localhost:2019/restaurants/restaurant/798</summary>

DATA

```JSON
{
    "telephone" : "555-555-1234",
    "seatcapacity" : 152
}
```

OUTPUT

```JSON
{
    "timestamp": "2020-01-28T21:39:29.766+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Restaurant 798 Not Found",
    "trace": "javax.persistence.EntityNotFoundException: Restaurant 798 Not Found\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServiceImpl.lambda$update$2(RestaurantServiceImpl.java:152)\n\tat java.base/java.util.Optional.orElseThrow(Optional.java:408)\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServiceImpl.update(RestaurantServiceImpl.java:152)\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServiceImpl$$FastClassBySpringCGLIB$$d47a1bf5.invoke(<generated>)\n\tat org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:769)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\n\tat org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:353)\n\tat org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:99)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\n\tat org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:689)\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServiceImpl$$EnhancerBySpringCGLIB$$a042fe30.update(<generated>)\n\tat com.lambdaschool.crudyrestaurants.controllers.RestaurantController.updateRestaurant(RestaurantController.java:198)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:566)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)\n\tat org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)\n\tat org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\n\tat org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)\n\tat org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)\n\tat org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\n\tat org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:880)\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:741)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\n\tat org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96)\n\tat org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:526)\n\tat org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:139)\n\tat org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\n\tat org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\n\tat org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\n\tat org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:408)\n\tat org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:66)\n\tat org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:861)\n\tat org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1579)\n\tat org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\n\tat java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)\n\tat java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)\n\tat org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\n\tat java.base/java.lang.Thread.run(Thread.java:834)\n",
    "path": "/restaurants/restaurant/798"
}

Status 500 Internal Server Error
```

</details>

<details>
<summary>PATCH http://localhost:2019/restaurants/restaurant/10</summary>

DATA

```JSON
{
    "telephone" : "555-555-1234",
    "seatcapacity" : 152
}
```

OUTPUT

```JSON
No Body

Status 200 OK
```

</details>

<details>
<summary>DELETE http://localhost:2019/restaurants/restaurant/4</summary>

```TEXT
No Body

Status of 200 OK
```

</details>

<details>
<summary>DELETE http://localhost:2019/restaurants/restaurant/4444</summary>

```JSON
{
    "timestamp": "2020-01-27T23:21:13.278+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Restaurant 4444 Not Found",
    "trace": "javax.persistence.EntityNotFoundException: Restaurant 4444 Not Found\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServiceImpl.delete(RestaurantServiceImpl.java:100)\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServiceImpl$$FastClassBySpringCGLIB$$d47a1bf5.invoke(<generated>)\n\tat org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:769)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\n\tat org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:353)\n\tat org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:99)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\n\tat org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:689)\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServiceImpl$$EnhancerBySpringCGLIB$$53c62e10.delete(<generated>)\n\tat com.lambdaschool.crudyrestaurants.controllers.RestaurantController.deleteRestaurantById(RestaurantController.java:230)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:566)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)\n\tat org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)\n\tat org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\n\tat org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)\n\tat org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)\n\tat org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\n\tat org.springframework.web.servlet.FrameworkServlet.doDelete(FrameworkServlet.java:931)\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:666)\n\tat org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:741)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\n\tat org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96)\n\tat org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:526)\n\tat org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:139)\n\tat org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\n\tat org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\n\tat org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\n\tat org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:408)\n\tat org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:66)\n\tat org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:861)\n\tat org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1579)\n\tat org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\n\tat java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)\n\tat java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)\n\tat org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\n\tat java.base/java.lang.Thread.run(Thread.java:834)\n",
    "path": "/restaurants/restaurant/4444"
}
```

</details>
