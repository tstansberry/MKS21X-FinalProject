# MKS21X-FinalProject
Final Project Name: Easy-Access Dictionary? <br />
Group Name: Group Name

# January 3rd
Timothy- Spent time studying Oxford API and its functionality, tested out sample programs from the documentation. Ultimately decided that is was too complicated and didn't have enough documentation.
Vishwaa- Spent time studying Oxford API and its functionality, tested out sample programs from the documentation. Started working on a JSON file using documentation.
# January 4th-6th
Timothy- Switched routes to web-scraping instead of API. Got Jsoup (jar library) working. Connected scraper to dictionary.com, was able to pull all of its html.<br />
Vishwaa- Made some progress with JSON integration. Found an alternative to using API from the documentation. Used swagger-codegen.jar to create JAVA files to access and use the API.
# January 7th
Timothy- Finally able to isolate the specific definition element that we needed... converting it into a string (after much trial and error). <br />
Vishwaa- 
# January 8th
Timothy- Switched up the functionality of the parser. Instead of taking the easy route (definition provided at the top), it now goes down deep into the code and finds the location with all possible definitions. Currently having an error with the Element method "getAttribute()". <br />
Vishwaa-
# January 9th
Timothy- Played around with various ways to access the specific definitions we needed... finally settled on the hard-coded way since the functions from the Elements interface weren't working. Made it possible to input the specific definition you want (0, 1, 2, etc.).
