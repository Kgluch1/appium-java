# Android Mobile Test Automation — Appium                                           
                                                                                                                                                                    
  Portfolio project: E2E test automation for the [Sauce Labs My Demo App](https://github.com/saucelabs/my-demo-app-android) Android application.                    
                                                                                                                                                                    
  ## Stack                                                                                                                                                          
                                                                                                                                                                    
  - Java 17
  - Appium 2.x + UiAutomator2
  - TestNG                                                                                                                                                          
  - Maven
  - Android Studio (emulator)                                                                                                                                       
                                                                                                                                                                    
  ## Project Structure
                                                                                                                                                                    
  src/test/java/                                                  
  ├── base/        # BaseTest — driver setup & teardown
  ├── pages/       # Page Object Model (LoginPage, CatalogPage, CartPage)                                                                                           
  ├── tests/       # Test classes (LoginTest, CatalogTest, CartTest)                                                                                                
  └── utils/       # WaitHelper — explicit waits                                                                                                                    
  src/test/resources/                                                                                                                                               
  └── config.properties                                                                                                                                             
                                                                                                                                                                    
  ## Test Coverage                                                                                                                                                  
   
  | Area    | Scenarios |                                                                                                                                           
  |---------|-----------|                                         
  | Login   | Valid credentials, wrong password, empty fields |                                                                                                     
  | Catalog | Product list visible on start, product detail opens on tap |                                                                                          
  | Cart    | Empty cart on start, adding product to cart |                                                                                                         
                                                                                                                                                                    
  ## Prerequisites                                                                                                                                                  
                                                                  
  - Java 17+                                                                                                                                                        
  - Maven
  - Android Studio with an AVD configured (Android 12+)                                                                                                             
  - Appium 2.x server running locally                                                                                                                               
  - Appium UiAutomator2 driver installed
                                                                                                                                                                    
  ```bash                                                         
  appium driver install uiautomator2                                                                                                                                
                                                                  
  Configuration                                                                                                                                                     
   
  Create src/test/resources/config.properties:                                                                                                                      
                                                                  
  appium.url=http://127.0.0.1:4723
  device.name=emulator-5554                                                                                                                                         
  app.package=com.saucelabs.mydemoapp.android
  app.activity=.view.activities.SplashActivity                                                                                                                      
  app.path=/absolute/path/to/mda-2.2.0-25.apk                     
                                                                                                                                                                    
  Running Tests
                                                                                                                                                                    
  Start Appium server, then:                                      

  mvn test

  Run a single test class:                                                                                                                                          
   
  mvn test -Dtest=LoginTest                      
