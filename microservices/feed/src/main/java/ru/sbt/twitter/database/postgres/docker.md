# Commands for docker

### Build image and run the container
docker-compose up -d --build 

### List of all containers
docker ps -a

### Stop the container
docker stop \<container id>

### Remove the container 
docker rm \<container id>

### List of all images
docker image ls

### Remove the image 
docker rmi \<image id> <br>
docker rmi \<repository>:\<tag>

### Remove all images
docker system prune -a

# How to run postgres database
#### before run
##### Check that previous versions of this container and image removed
##### if you want new back up data check that pddata floder removed
#### run 
docker-compose up -d --build
#### local copy of database located in pgdata

