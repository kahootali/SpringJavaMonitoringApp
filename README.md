# SpringJavaMonitoringApp

A basic Java monitoring application with prometheus endpoint to expose counter endpoint which increments count whenever accessed.

## Deploy

You need to have a `p12` file containing cert for your domain, and when running the container, you need to expose these env vars:

- KEYSTORE: path containing your p12 file inside the container
- KEYSTORE_PASSWORD: Password for you p12 file

### Docker

You can edit the script `docker-build-run.sh`, and set the `PATH_TO_P12` env var as the local folder containing your `kstore.p12` file.

### Kubernetes

The Kubernetes deployment & related files are in `deploy/` folder. You can see the image from Dockerhub and update to the latest one if required.

There is also an Ingress which exposes this Service and uses Ingress Nginx Controller with class defined as `nginx-mtls`, the domain being used is `kahootali.com`, you can change to your domain.

You will also have to create the secret containing your p12 file, you can create by running

```sh
kubectl create secret generic store --from-file=kstore.p12
```
