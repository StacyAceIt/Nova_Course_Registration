# Nova_Course_Registration

1. download Selenium Chrome webdriver from https://chromedriver.chromium.org/downloads
3. For MacOS, 
   xattr -d com.apple.quarantine chromedriver
4. comment out delay() method when registering for classes
5. variables needed to be set up before registration:

    1) MyWebdriver: set absolute path to webdriver
    2) Login: set username
    3) Login: set password 
    4) Term: set term e.g. Fall 2020
    5) Registration (Main Class) classSearch method: set course number e.g. 8566 
    6) Registration (Main Class) classSearch method: set CRN (Course Reference Number) e.g. 22723
    7) Registration (Main Class) classSearch method: set department e.g. CSC

Example course: CSC 8566 - 001 Internet of Things CRN: 22723

Memo: What if the course has been selected or registration status is closed?
      The program won't throw an error, it will hit Register button
      but nothing will be registered since there is no checkbox.

6. check course catalog to get course number and CRN before registration
   https://novasis.villanova.edu/pls/bannerprd/bvckschd.p_disp_dyn_sched

7. program workflow
     1) novasis login -> fill username args[1] and password args[2]
     2) select Student & Financial Aid tag
     3) select Registration
     4) Login to Registration -> might need to fill PIN
     5) select semester (arg[3])
     6) class search
     7) select department (default is set to Computer Science)
     8) select course with course number arg[4] -> view options
     9) find the CRN, click check box and register (arg[5] CRN)
     program goes back to step 6 when there is another class to register
