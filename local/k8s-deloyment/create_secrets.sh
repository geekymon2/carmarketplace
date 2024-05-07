
kubectl create secret generic encryptkeysecret --namespace carmarketplace-dev --from-literal encryptkeysecret=<value>
kubectl create secret generic carinfodbpassword --namespace carmarketplace-dev --from-literal carinfodbpassword=<value>