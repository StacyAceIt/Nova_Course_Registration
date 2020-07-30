# Nova_Course_Registration

1. download Selenium Chrome webdriver from https://chromedriver.chromium.org/downloads
2. download Selenium Client & WebDriver Language Bindings https://www.selenium.dev/downloads/ and add jars to Perperties --> java build path --> Libraries --> Add external jars
3. For MacOS, 
   xattr -d com.apple.quarantine chromedriver
4. comment out delay() method when registering for classes
5. command line arguments: 
 args[0] path to webdriver
 args[1] username
 args[2] password 
 args[3] term e.g. Fall 2020 (Fall\ 2020)
 args[4] course number e.g. 8566 
 args[5] CRN (Course Reference Number) e.g. 22723

Example course: CSC 8566 - 001 Internet of Things CRN: 22723

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
