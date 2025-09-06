FROM node:alpine3.21
WORKDIR /restapp
COPY package.json .

# Execute any commands on top of the current image as a new layer and commit the results. ecxecuted when image is being built
RUN npm install
COPY index.js .
# There can only be one CMD instruction in a Dockerfile.
# Provide defaults for an executing container. this is executed when the container is running
CMD [ "node","index.js" ]
