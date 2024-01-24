import os
import pyfiglet 

if __name__=="__main__":
	print(pyfiglet.figlet_format("Starting Server"))
	os.system("docker-compose -f conf/docker-compose.yml up -d")
	os.system("mvn clean --file app/pom.xml")
	os.system("mvn compile --file app/pom.xml")
	os.system("mvn test --file app/pom.xml --fail-never")
	os.system("docker-compose -f conf/docker-compose.yml down")
