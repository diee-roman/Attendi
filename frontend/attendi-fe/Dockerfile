### STAGE 1:BUILD ###
FROM node:alpine AS build
WORKDIR /app
COPY ./src /app/src
COPY ./angular.json /app/angular.json
COPY ./package.json /app/package.json
#COPY ./package-lock.json /app/package-lock.json
COPY ./tsconfig.app.json /app/tsconfig.app.json
COPY ./tsconfig.json /app/tsconfig.json
COPY ./tsconfig.spec.json /app/tsconfig.spec.json
COPY dist /app/dist
#RUN npm install
#RUN npm run build --prod
#RUN ls /app/dist

### STAGE 2:RUN ###
FROM nginx:latest
# NOTE: This path may change according to your project's output folder
COPY --from=build /app/dist/attendi-fe /usr/share/nginx/html
#COPY ../../infra/nginx/nginx.conf  /etc/nginx/conf.d/default.conf
CMD ["nginx", "-g", "daemon off;"]

EXPOSE 80
