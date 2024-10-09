make run-dist:
	./build/install/app/bin/app

make build:
	./gradlew clean build
	./gradlew test
	./gradlew checkstyleMain

make report:
	./gradlew jacocoTestReport

.PHONY: build
