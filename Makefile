.PHONY: build-and-deploy
build-and-deploy:
	./gradlew assemble
	docker build -t rb-api .
	docker tag rb-api gfds/rb-api:latest
	#docker push gfds/rb-api:latest

.PHONY: build-nginx
build-nginx:
	docker build -t rb-lb ./conf
	docker tag rb-lb gfds/rb-lb:latest
	#docker push gfds/rb-lb:latest

.PHONY: down
down:
	docker-compose down
	docker volume rm rb-micronaut_db-data

.PHONY: run
run: down build-and-deploy
	docker-compose up --build

