# MKS21X-FinalProject
Final Project Name: Terminal Dictionary 
Group Name: Soberry

<br />

Instructions to use our project:

1. javac -cp lanterna.jar:jsoup-1.11.3.jar:. TerminalDemo.java
2. java -cp lanterna.jar:jsoup-1.11.3.jar:. TerminalDemo
3. Type in a word 
4. Press ENTER
5. Type in a mode
6. Press ENTER
7. Dictionary does it's magic ;)

<br />

# January 3rd
Timothy- Spent time studying Oxford API and its functionality, tested out sample programs from the documentation. Ultimately decided that is was too complicated and didn't have enough documentation. <br />
Vishwaa- Spent time studying Oxford API and its functionality, tested out sample programs from the documentation. Started working on a JSON file using documentation.
# January 4th-6th
Timothy- Switched routes to web-scraping instead of API. Got Jsoup (jar library) working. Connected scraper to dictionary.com, was able to pull all of its html.<br />
Vishwaa- Made some progress with JSON integration. Found an alternative to using API from the documentation. Used swagger-codegen.jar to create JAVA files to access and use the API.
# January 7th
We decided to use JSOUP over the API at time point of our project. <br />

Timothy- Finally able to isolate the specific definition element that we needed... converting it into a string (after much trial and error). <br />
Vishwaa- Familiarized myself with JSOUP and the current code. Helped Timothy with the isolation of the tags.
# January 8th
Timothy- Switched up the functionality of the parser. Instead of taking the easy route (definition provided at the top), it now goes down deep into the code and finds the location with all possible definitions. Currently having an error with the Element method "getAttribute()". <br />
Vishwaa- Helped Timothy find the associated tags so he could modify the Elemnent part of the code accoringly. We decided to use <li> as the tag had an associated "value" ID, which we coould locate. 
# January 9th
Timothy- Played around with various ways to access the specific definitions we needed... finally settled on the hard-coded way since the functions from the Elements interface weren't working. Made it possible to input the specific definition you want (0, 1, 2, etc.). <br />
Vishwaa- Changed the output to only return the text within the HTML tags. Started working on terminal interface.
# January 10th
Timothy- Wasn't able to work on anything, studying for 2 tests. <br />
Vishwaa- Finished developing a GUI screen. Had to switch to using lanterna.
# January 11th-13th
Timothy- Added a new scraping method to get synonyms from thesaurus.com. Created a master function that complies all the methods into one. Added comments into code. Met up with Vishwaa and got lanterna working after much trial and error.<br />
Vishwaa- Started developing a usable lanterna screen which takes user input and displays result from Scraper.java. This is an inital version for demos, which will be expanded upon afterwards. <br />
# January 14th
Timothy- Created a new file to redesign our visual interface. Started integrating the code from old visual into the new file. <br />
Vishwaa- Finished working on the MVP version of the lanterna screen to display results and inputs. Created a special function which make the idea of putString more flexuible. Used the old terminal display code and started testing modes and integrating them within code.
Ready for Presentations!
# January 15th
Timothy- Wasn't able to work on anything, had to study for 2 finals the next day.<br />
Vishwaa- 
# January 16th
Timothy- Decided to leave Vishwaa to work with lanterna, worked on generating a random word. Encountered problems with the website requiring the user to push buttons to generate the words. <br />
Vishwaa- 

  
