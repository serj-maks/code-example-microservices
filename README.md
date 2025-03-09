# code-example-microservices
spring boot, reactive


## как запустить
скачать docker-контейнер с zipkin
```md
docker pull openzipkin/zipkin
```

запустить docker-контейнер с zipkin
```md
docker run -d --name zipkin-container -p 9411:9411 openzipkin/zipkin
```

запускаем по-порядку микросервисы
- config-server
- service-registry
- department-service
- employee-service
- api-gateway

теперь можно подергать REST, например через postman

GET
- http://localhost:8060/employee/1

GET (get all)
- http://localhost:8060/employee

POST
- http://localhost:8060/employee
```json
{
	"id":1,
	"departmentId":2,
	"name":"john",
	"age", 30,
	"position":"manager"
}
```
>адрес 8060 - это адрес балансира(api-gateway), т.е. не нужно обращаться к конкретному микросервису,
>можно отправлять все в балансир, а он разберется

GET
- http://localhost:8060/department/1

GET (get all)
- http://localhost:8060/department

POST
- http://localhost:8060/department
```json
{
	"id":1,
	"name":"IT"
}
```
