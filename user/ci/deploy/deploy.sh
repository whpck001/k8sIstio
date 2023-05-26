#!/bin/bash


if [ "${CI_COMMIT_REF_NAME}" == "develop" ]; then export K8S_INGRESS_DOMAIN=${DOMAIN_DEVELOP}; export K8S_NAMESPACE=istio; fi;
cp ci/deploy/configmap.${CI_COMMIT_REF_NAME}.yaml ci/deploy/configmap.yaml

# 替换部署文件中的环境变量
sed -i 's/${project_name}/'${UNIQUE_NAME}'/g' ci/deploy/*
sed -i 's/${namespace}/'${K8S_NAMESPACE}'/g' ci/deploy/*
sed -i 's/${replicas}/'${REPLICAS}'/g' ci/deploy/deploy.yaml
sed -i 's/${image_repository}/'${IMAGE_REPOSITORY}'/g' ci/deploy/deploy.yaml

kubectl apply -f ci/deploy/configmap.yaml --kubeconfig=$HOME/.kube/config.aks
kubectl apply -f ci/deploy/deploy.yaml --kubeconfig=$HOME/.kube/config.aks
kubectl apply -f ci/deploy/service.yaml --kubeconfig=$HOME/.kube/config.aks
echo "APPLY SUCCESS"

