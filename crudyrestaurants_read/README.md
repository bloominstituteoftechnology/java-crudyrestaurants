# Java Reading CRUDy Restaurants

A student that completes this project shows that they can:

* Perform CRUD operations on an RDBMS using JPA and Hibernate (reading)
* Implement seed data using SQL statements
* Explain and use Spring Data Relationships
* Use the JsonIgnoreProperties annotation to prevent infinite loops
* Use JPA constructs to create advanced queries

## Introduction

This is a basic database scheme with restaurants, menus, payment system. This Java Spring REST API application will provide endpoints for clients to read various data sets contained in the application's data. In this version sample GETs have been added. Clients can now read the data!

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
    "timestamp": "2020-03-16T21:45:33.426+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Restaurant 77 Not Found",
    "trace": "javax.persistence.EntityNotFoundException: Restaurant 77 Not Found\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServicesImpl.lambda$findRestaurantById$0(RestaurantServiceImpl.java:50)\n\tat java.base/java.util.Optional.orElseThrow(Optional.java:408)\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServicesImpl.findRestaurantById(RestaurantServiceImpl.java:50)\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServicesImpl$$FastClassBySpringCGLIB$$d47a1bf5.invoke(<generated>)\n\tat org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:769)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\n\tat org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:366)\n\tat org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:99)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\n\tat org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:689)\n\tat com.lambdaschool.crudyrestaurants.services.RestaurantServicesImpl$$EnhancerBySpringCGLIB$$bbbb8f34.findRestaurantById(<generated>)\n\tat com.lambdaschool.crudyrestaurants.controllers.RestaurantController.getRestaurantById(RestaurantController.java:58)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:566)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)\n\tat org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)\n\tat org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\n\tat org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)\n\tat org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)\n\tat org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\n\tat org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:634)\n\tat org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:741)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\n\tat org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96)\n\tat org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:541)\n\tat org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:139)\n\tat org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\n\tat org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\n\tat org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\n\tat org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:367)\n\tat org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)\n\tat org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:860)\n\tat org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1598)\n\tat org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\n\tat java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)\n\tat java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)\n\tat org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\n\tat java.base/java.lang.Thread.run(Thread.java:834)\n",
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

<details>
<summary>http://localhost:2019/restaurants/restaurant/likedish/cheese</summary>

```JSON
[
    {
        "restaurantid": 4,
        "name": "Apple",
        "address": "123 Main Street",
        "city": "City",
        "state": "ST",
        "telephone": "555-555-1234",
        "seatcapacity": 15,
        "payments": [
            {
                "paymentid": 3,
                "type": "Mobile Pay"
            },
            {
                "paymentid": 1,
                "type": "Cash"
            },
            {
                "paymentid": 2,
                "type": "Credit Card"
            }
        ],
        "menus": [
            {
                "menuid": 5,
                "dish": "Mac and Cheese",
                "price": 6.95
            },
            {
                "menuid": 6,
                "dish": "Lasagna",
                "price": 8.5
            },
            {
                "menuid": 7,
                "dish": "Meatloaf",
                "price": 7.77
            },
            {
                "menuid": 8,
                "dish": "Tacos",
                "price": 8.49
            },
            {
                "menuid": 9,
                "dish": "Chef Salad",
                "price": 12.5
            }
        ]
    },
    {
        "restaurantid": 115,
        "name": "Gamma Quadrant Cafe",
        "address": "762 Jerde Streets",
        "city": "East Gail",
        "state": "IA",
        "telephone": "(715) 551-4602",
        "seatcapacity": 74,
        "payments": [
            {
                "paymentid": 1,
                "type": "Cash"
            }
        ],
        "menus": [
            {
                "menuid": 116,
                "dish": "Tiramisù",
                "price": 84.6
            },
            {
                "menuid": 117,
                "dish": "Fish and Chips",
                "price": 43.7
            },
            {
                "menuid": 118,
                "dish": "Cheeseburger",
                "price": 28.05
            },
            {
                "menuid": 119,
                "dish": "Caprese Salad",
                "price": 88.79
            },
            {
                "menuid": 120,
                "dish": "Chicken Fajitas",
                "price": 28.13
            }
        ]
    }
]
```

</details>

<details>
<summary>http://localhost:2019/restaurants/menucounts</summary>

```JSON
[
    {
        "name": "Bajor Cafe",
        "countmenus": 10
    },
    {
        "name": "Tau Ceti Prime Cafe",
        "countmenus": 10
    },
    {
        "name": "Thalos VII Cafe",
        "countmenus": 9
    },
    {
        "name": "Wolf 359 Cafe",
        "countmenus": 9
    },
    {
        "name": "Alpha Quadrant Cafe",
        "countmenus": 8
    },
    {
        "name": "Qo'noS Cafe",
        "countmenus": 8
    },
    {
        "name": "Badlands Cafe",
        "countmenus": 7
    },
    {
        "name": "Ferenginar Cafe",
        "countmenus": 7
    },
    {
        "name": "Risa Cafe",
        "countmenus": 7
    },
    {
        "name": "Beta Quadrant Cafe",
        "countmenus": 6
    },
    {
        "name": "Vulcan Cafe",
        "countmenus": 6
    },
    {
        "name": "Apple",
        "countmenus": 5
    },
    {
        "name": "Cardassia Cafe",
        "countmenus": 5
    },
    {
        "name": "Delta Quadrant Cafe",
        "countmenus": 5
    },
    {
        "name": "Gamma Quadrant Cafe",
        "countmenus": 5
    },
    {
        "name": "The Briar Patch Cafe",
        "countmenus": 5
    },
    {
        "name": "Betazed Cafe",
        "countmenus": 4
    },
    {
        "name": "Deep Space Nine Cafe",
        "countmenus": 4
    },
    {
        "name": "Khitomer Cafe",
        "countmenus": 3
    },
    {
        "name": "Neutral Zone Cafe",
        "countmenus": 3
    },
    {
        "name": "Eagle Cafe",
        "countmenus": 2
    },
    {
        "name": "Romulus Cafe",
        "countmenus": 2
    },
    {
        "name": "Number 1 Eats",
        "countmenus": 1
    },
    {
        "name": "Trillius Prime Cafe",
        "countmenus": 1
    }
]```

</details>