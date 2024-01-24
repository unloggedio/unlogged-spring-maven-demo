echo "Starting Tests"
cd app
docker build .
cd ../conf
docker-compose up

echo "Test complete"
exit