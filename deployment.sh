docker compose stop
docker rmi -f mhbappy18/currency_configure &>/dev/null && echo 'Removed old container'
docker compose up -d

#docker stop user_application-1
#docker rm user_application-1
#docker rmi hasan18/user_application
#docker compose up -d