# owasp-zap-selenium-demo
### Setup
- Clonse this repository and update geckodriver as per your operating system, currently geckodriver is for MAC os.
- Make Sure TARGET URL, Ports are correct in SimpleZAPExample class.
### Running the Demo 
- Download Owasp ZAP and start it
  ``` ./zap.sh -host localhost -port 8090 -daemon ```
- Run SeleniumDemo as main java program

It will generate report.xml with details of alerts found.
