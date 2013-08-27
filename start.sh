# Check for target dir
if [[ ! -d "target" ]]; then
    mvn clean install
fi

mvn exec:java -Dexec.mainClass=com.ns.orders.Main
