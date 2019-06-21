# About the codebase

This is the demo project for testing on flight/hotel booking website. 

# Prerequisite

  - TestNG.
  - Selenium Client.
  - Set up system path with selenium client.
  
  # How to set system path with selenium client.
  - Download desired selenium client from https://www.seleniumhq.org/download/ ((eg : Java)
  - Provide the system path in testng.xml file .
  
    Code :
 !DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
 
 <suite name="Suite" parallel="none">
 
 <test name="Flight">
 
 <parameter name="browserName" value="chrome" />
 <parameter name="url" value="https://www.cleartrip.com/" />
 <parameter name="driverPath" value="/home/cepl/Documents/Selenium things/chromedriver_linux64/chromedriver"/>
 
 <classes>

 <class name="flight.FlightFunctionality" />
 
 </classes>
 
 </test>
 

 
</suite>

 
