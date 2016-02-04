Q1. What is Logging?
Q2. Why Logging
Q3. How Logging
a) Download Log4j Jar File
b) Copy Jar and Paste it in Project
c) R.C on Project --> Properties --> Java Build Path --> Library --> Add 
d) Create Property File (Log File Location , Size , Format) (src location)
log4j.properties 
e) Logger Object Create (Every File)
i) Logger logger = Logger.getLogger(className.class);
ii) logger.error("Exception Caught ")