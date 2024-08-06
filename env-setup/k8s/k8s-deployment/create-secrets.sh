kubectl create secret generic encryptkeysecret --namespace carmarketplace-dev --from-literal encryptkeysecret=$ENCRYPT_KEY_SECRET
kubectl create secret generic carinfodbpassword --namespace carmarketplace-dev --from-literal carinfodbpassword=$CARINFO_DB_PASSWORD
kubectl create secret generic carlistingdbpassword --namespace carmarketplace-dev --from-literal carlistingdbpassword=$CARLISTING_DB_PASSWORD
kubectl create secret generic userdbpassword --namespace carmarketplace-dev --from-literal userdbpassword=$USER_DB_PASSWORD
kubectl create secret generic jwtauthsecret --namespace carmarketplace-dev --from-literal jwtauthsecret=$JWT_AUTH_SECRET