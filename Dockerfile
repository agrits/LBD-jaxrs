FROM airhacks/glassfish
COPY ./target/jaxrs.war ${DEPLOYMENT_DIR}
