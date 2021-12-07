FROM node:14-alpine
ENV NODE_ENV=production
WORKDIR /app.js
COPY ["package.json", "package-lock.json*", "npm-shrinkwrap.json*", "./"]
RUN npm install 
COPY . .
EXPOSE 3000
EXPOSE 8080
CMD ["npm", "start"]
