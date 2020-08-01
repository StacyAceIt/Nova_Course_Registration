# Nova_Course_Registration

1. download Selenium Chrome webdriver from https://chromedriver.chromium.org/downloads
3. For MacOS, 
   xattr -d com.apple.quarantine chromedriver
4. comment out delay() method when registering for classes
5. variables needed to be set up before registration:

    1) Command Line arg[0]: set absolute path to webdriver
    2) Command Line arg[1]: set username
    3) Command Line arg[2]: set password 
    4) Term Class: set term e.g. Fall 2020
    5) Registeration Class (Main Class) classSearch method: Line 261-261 set course number e.g. 8566 
    6) Registeration Class (Main Class) classSearch method: Line 261-261 set CRN (Course Reference Number) e.g. 22723
    7) Registeration Class (Main Class) classSearch method: Line 261-261 set department e.g. CSC
    8) Registeration Class (Main Class) main method: around Line 31: set timer to run application
    9) PIN class: set PIN

Example course: CSC 8566 - 001 Internet of Things CRN: 22723

Memo: What if the course has been selected or registration status is closed?
      The program won't throw an error, it will hit Register button
      but nothing will be registered since there is no checkbox.
      
Note: Can use an already registered or closed course for testing, then there is no need to drop.

6. check course catalog to get course number and CRN before registration
   https://novasis.villanova.edu/pls/bannerprd/bvckschd.p_disp_dyn_sched

7. program workflow
     Detour login starts from here
     1) novasis login -> fill username args[1] and password args[2]
     2) select Student & Financial Aid tag
     3) select Registration
     
     Shortcut login starts from here (The link for shortcut login may not work 100% of time. The application will automatically choose Shortcut/Detour login. If none of the two is accessible, it will wait for 30 seconds and try to login again)
     4) Login to Registration -> might need to fill PIN
     5) select semester (arg[3])
     6) class search
     7) select department (default is set to Computer Science)
     8) select course with course number arg[4] -> view options
     9) find the CRN, click check box and register (arg[5] CRN)
     program goes back to step 6 when there is another class to register
