Para ejecución local, dentro de cada archivo

	mvn clean install
	mvn spring-boot:run

Puertos locales 

	8091: Servicio Cliente
	8092: Servicio Cuartos
	8093: Servicio Reservación

Acceso a Swagger

http://localhost: PUERTO /swagger-ui/index.html#/

Comandos de ejecución Docker

	mvn clean package
	docker build -t serviceclient .
	docker run -it --rm -p 3001:8091 --name myserviceclient serviceclient

	mvn clean package
	docker build -t serviceroom .
	docker run -it --rm -p 3002:8092 --name myserviceroom serviceroom

	mvn clean package
	docker build -t servicereservation .
	docker run -it --rm -p 3003:8093 --name myservicereservation servicereservation

Se ajunta Collección de Postman

	Hotel-Service.postman_collection.json