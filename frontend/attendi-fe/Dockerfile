### STAGE 1:BUILD ###
FROM node:alpine AS build
WORKDIR /app
COPY ./src /app/src
COPY ./angular.json /app/angular.json
COPY ./package.json /app/package.json
COPY ./tsconfig.app.json /app/tsconfig.app.json
COPY ./tsconfig.json /app/tsconfig.json
COPY ./tsconfig.spec.json /app/tsconfig.spec.json
RUN npm install
RUN npm run build --prod

### STAGE 2:RUN ###
FROM nginx:latest
COPY --from=build /app/dist/attendi-fe /usr/share/nginx/html
CMD ["nginx", "-g", "daemon off;"]

EXPOSE 80
