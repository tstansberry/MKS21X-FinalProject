# MKS21X-FinalProject
Final Project Name: Terminal Dictionary 
Group Name: Soberry

<br />

Instructions to use our project:

1.<br />
a. MAC/Linux: javac -cp lanterna.jar:jsoup-1.11.3.jar:. TerminalDemo.java<br />
b. Windows: javac -cp "lanterna.jar;jsoup-1.11.3.jar;." TerminalDemo.java<br />
2.<br />
a. MAC/Linux: java -cp lanterna.jar:jsoup-1.11.3.jar:. TerminalDemo<br />
b. Windows: java -cp "lanterna.jar;jsoup-1.11.3.jar;." TerminalDemo<br />
3. Type in what mode. Format [number]; Example: [1]<br />
4. Press ENTER and confirm with SPACE<br />

MODES 1-3<br />
5. Enter a word<br />
6. Press ENTER and confirm with SPACE<br />
7. Press LEFT ARROW to return to main menu<br />

MODE 4<br />
5. Type your guess and press ENTER<br />
6. Use TAB if you want to be a cheater (DON'T!)<br />
7. Play until game is over<br />
8. Press LEFT ARROW to return to main menu<br />

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
Vishwaa- Helped Timothy find the associated tags so he could modify the Elemnent part of the code accoringly. We decided to use the li tag as the tag had an associated "value" ID, which we coould locate. 
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
Vishwaa- Finished working on the MVP version of the lanterna screen to display results and inputs. Created a special function which make the idea of putString more flexuible. Used the old terminal display code and started testing modes and integrating them within code. (WAS ABSENT IN CLASS THIS DAY)
Ready for Presentations! 
</br>
# January 15th
Timothy- Wasn't able to work on anything, had to study for 2 finals the next day.</  br>
Vishwaa- Incorporated Timothy's code from new file and made the new version working with no errors.
</  br>
# January 16th
Timothy- Decided to leave Vishwaa to work with lanterna, worked on generating a random word. Encountered problems with the website requiring the user to push buttons to generate the words. <br />
Vishwaa- Did not get to work much on this day because of finals.
</br>
# January 17th
Timothy- Continued search for a random word sight, scoured through various websites (and their html) trying to find one that actually generated words when you loaded the page (placing them in the html).</br>
Vishwaa- Got the mode functionality we wanted working.
</br>
# January 18th
Timothy- Finally found random site and finished up random code, started working on the code for the game.</br>
Vishwaa- Main screen display built: allows for mode entry. Code combined into TerminalDemo.java.
</br>
# January 19th
Timothy- Continued working on the game, but realized that there is an issue with our definition scraper. Nothing has been changed, so I'm not sure what's wrong. I might have to switch the scraper to a different dictionary site. </br>
Vishwaa- Reorganized code to separate input-directed stuff and normal display stuff and added documentation. Completed transition into display 1 for word input and what the display looks like. Worked on giving users flexibility with their inputs and changing them before proceeding to main output screen. 
</br>
# January 20th
Timothy- Spent time trying to figure out what was wrong, discovered that dictionary.com actually changed their html format.</br>
Vishwaa- Finished display 1 and modified input features such as Backspace. Successfully connected word input and mode input on display 0 and 1 into creating an output screen based off inputs. Helped Timothy find tags and IDs and read documentation to help implement the changes to fix broken code in Scraper because of which our defintion part didnt work.  </br>
NOTE: DICTIONARY.COM CHANGED THEIR HTML AND WE HAD TO FIND RELEVANT TAGS AND IDS TO FIX SCRAPER.JAVA. </br>

# January 21st - January 25th
Timothy- Finally was able to figure out how to get the definitions we need with the new html format, finalized game code. </br>

Vishwaa- From January 21st to the 25th, I spent most of the time working on allowing the user to interact efficiently with the program. I was able to implement features that allowed them to go back to the main menu, confirm their input, change their input in order to give them flexibility. I also worked on making sure the defintions printed properly and the layout was neat. The last thing was connecting the game code to the terminal display so the backend could check user input and properly display results and update defintion and scores accoridingly.
