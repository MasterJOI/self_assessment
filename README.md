# To deploy build&deploy
1. On the server go to  dir with dockerfile (`/opt/dev-sa-back`), should also be service (`/opt/analyzer-masters`) by Sytnik I.O.
2. Fill .env envirounment variables (example):
   SPRING_PROFILES_ACTIVE=dev
   RDS_DB_NAME=self_assessment_educational_programs_storage
   PORT_OUT=32793
   ANALYZER_PORT=32794
   RDS_HOSTNAME=postgres
   RDS_USERNAME=postgres
   RDS_PASSWORD=debug
   FILE_PATH=./src/main/resources/files
   CLIENT_HOST=https://acs-ipze.pp.ua/
   JWT_SECRET=
   SCOPUS_SECRET_KEY=
   SCOPUS_SECRET_TOKEN=
   GROBID_HOME=/opt/analyzer-masters/grobid/grobid-home/
3. and run  `docker-compose build
   docker-compose down
   docker compose up -d`
