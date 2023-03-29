package SeleniumRecap;

public class InterviewQuestions {
    /*
    1-What are the advantages and disadvantages of Selenium?
    Advantages: *Free Resource
                *It supports multiple languages and browsers
                *It has big community
    Disadvantages:  *You cannot automate captcha, pictures,mobile applications etc...
                    *There is no direct call(customer service) for support
                    *It only automates Web Application(Browser)
                    *It doesn't have any system to generate report,so we use
                    external resource(testing,cucumber etc...)

    2-What type of testing can you automate with Selenium?
        *Regression
        *Smoke
        *Functional test(positive and negative testing)

    3-What are the test types you don't automate with Selenium?
        *Performance Testing(Jmeter-->it is not really hard to learn)
        *Manuel Testing(captcha,pictures)
        *Non-Functional Testing(stress testing,loading testing,performance...)
        *Adhoc testing(randomly testing)

    4-What is the locator in Selenium? What types of locators do you use in your framework?
        -->Locator is a way to find the element/s from DOM(development tool/page)
        The locators that I am using in my framework are:
            ID: finds the element with ID attribute
            NAME: finds the element with Name attribute
            ClassName: finds the element with ClassName attribute
            TagName: finds the element with TagName
            LinkText: finds the element with "a" tagName and "Text"
            PartialLinkText: finds the element with "a" tagName and "partialText" or fullText
            CSS: finds the element with CSS(id or class) -> for id (#), for class(.)
            Xpath: finds the element with Xpath.

    5-How do you handle dynamic elements in UI automation? (CVS interview question)
        In my project, I have faced many dynamic elements during UI automation:
        -->To handle this issue I did:
            *I used parent-child relationship for elements
            *I used different ways to locate the elements(like following-sibling,
            preceding-sibling,contains etc...)
            *I found the element with different attribute which is not dynamic

    6-Difference between driver.get() and driver.navigate()?
        Navigate()--> It doesn't wait WebElement to be loaded from page.(It waits for
                        only specific element that you are looking from page)
                  --> It has methods(to,refresh,back,forward)

                Get()--> I waits all the WebElements from page to be loaded
                     --> It doesn't have any methods

    7-Difference between driver.close() and driver.quit()?
          driver.close(): It specifically closes the window that your driver is pointing.
                         *It closes only one tab

          driver.quit(): It closes all the tabs that were opened during the automation run.

    8-What is Xpath and can you tell me about types of Xpath? Which one do you use the most?
        8.1-What is difference between Absolute and Relative Xpath?
            Xpath: It is one of the locators that I use in Selenium to find the element.
               There are 2 types of Xpath:
                    1-Absolute Xpath:
                        *It goes from all way top(HTML) to child
                        *It starts with single slash(/)
                    2-Relative Xpath:
                        *It goes directly to the child or parent/child
                        *It starts with double slash(//)

        Note: I use definitely relative xpath the most since it is more functional and  effective to locate the element

    9-How do you handle drop-downs?
        In my project, I was handling drop-downs with different ways:
            * I would definitely check the tag of the WebElement(location)
              * If the location has "SELECT" tagName then I use Select Class
                Example: Select select = new Select(WebElement);
              * If the location doesn't have "SELECT" tagName then I can use:
                -Action class methods like click or WebElement method click and choose option
                -I would use sendKeys() to choose the option

    10-Can you tell me what do you know about Select class and its methods?
        Select class is way to handle drop-downs:
            It is useful for my project.
            The WebElement must have Select TagName

        Select select = new Select(location);
            *select.selectByVisibleText("TextValue")
            *select.selectByValue("Value")
            *select.selectByIndex("IndexNumber")
            *select.getFirstSelectedOption()--> It will give you default option selected
            *select.getOptions()-->It will give you all options(List<String>)

    11-What kind of exceptions have you faced in your automation Framework?
        -NOSUCHELEMENTEXCEPTION
        -STALEELEMENTREFERENCEEXCEPTION
        -ELEMENTINTERCEPTEDEXCEPTION
        -ELEMENTISNOTINTERACTABLEEXCEPTION
        -NOSUCHWINDOWEXCEPTION
        -NOSUCHFRAMEEXCEPTION
        -TESTNGEXCEPTION
        -UNHANDLEDALERTEXCEPTION
        -TIMEOUTEXCEPTION
        -INVALIDSELECTOREXCEPTION

    12-How do you handle STALEELEMENTREFERENCEEXCEPTION?
        In my project this exception is one of the hard ones that was giving me headache:
        -->This exception happens when:
           *DOM is not updated fast
           *DOM's element values is changed
           *The page is refreshed
        -->Wait times might solve the issue
            -->I would use Thread.sleep or Explicitly wait with condition
            *-->I would reassign and reinitialize the WebElement
            -->I would refresh the page

     13-How do you handle pop-ups?
        There are different types of popUps I faced during automation:
        --> OS popup --> We cannot handle it directly with Selenium
        --> HTML popUp --> I just need to find element and click on it OK or Cancel
         --> JS popUp --> I handle it with alert interface

        Alert alert = driver.switchTi.alert();
        alert.accept() -> it clicks OK button
        alert.dismiss() -> it clicks CANCEL button
        alert.getText() -> it gets the text from alert
        alert.sendKeys() -> it sends key to the alert

    14-What do you know about IFRAME? and do you handle this in your automation?
        IFRAME is html inside html.
        It is used for protection purpose
        It is widely used for Ads,documents or Videos
        ->First switch your frame based on the value of WebElement:
            -->driver.switchTo.frame(id or name)
            -->driver.switchTo.frame(WebElement)
            -->driver.switchTo.frame(Index)
            -->driver.switchTo.ParentFrame()-> it will go to the parent frame
            -->driver.switchTo.defaultContent()-> it will NO matter what go to the main html directly

        NOTE: If you do not handle iframe, you will get NOSUCHELEMENTEXCEPTION
        NOTE: If the value of switch frame is wrong, you will get NOSUCHFRAMEEXCEPTION

    15-What do you know about actions class and can you tell me the methods you use most during automation?
        Actions class basically does the functionality of mouses. I can say it is really useful in some cases during
        my automation to handle some elements. Some of important methods are:
         ***->ContextClick: It right clicks on the WebElement
            ->DoubleClick: It double clicks element
            ->DragAndDrop: It drags and drops the element from one spot the another spot
            ->ClickAndHold: It clicks and hold the element
            ->MoveToElement: It hovers over the element
            ->release: It releases the element that you are holding(it mosly comes after clickAndHold)
            ->click: It click the element
            ->sendKeys: It sends key to the element
         ***->perform: It performs the actions method.(WITHOIT THAT IT WILL NOT WORK)

    16-What is the difference between driver.findElement and driver.findElements?
        *FindElement: 1-driver.findElement(By.locator(""); Syntax
                      2-Returns single element
                      3-Once it fails, it throws NOSUCHELEMENTEXCEPTION

        *Find Elements: 1-driver.findElements(By.locator("")); Syntax
                        2-Returns List<WebElement>
                        3-once it fails, it returns nothing(empty list)

    17-Can you tell me some driver and WebElement methods you use during automation mostly?
        Driver Methods: *get() *navigate(), *getTitle(), *getCurrentURL, *switchTo(), *quit(), *close(), *GetWindowHandle/s, *manage()
        WebElement Methods: *click(), *sendKeys(), *getText(), *isDisplayed(), *isSelected(), *getAttribute(), *getCSSValue, *clear(), *submit()

    18-What is the difference between check-box and radio button?
        CheckBox-->you can click multiple boxes
        RadioBox-->you can choose only one

    19-How do you handle multiple windows in automation? and What is the difference between getWindowHandle() and getWindowHandles()?
        To be able to handle the window:
            I need to switch my driver into the specific window with my logic
            Set<String> allWindow=driver.getWindowHandles();
            for(String pageID:allWindow){
            driver.switchTo.window(pageId);
            if(driver.getTitle.contains(expectedTitle)){
            break;}

            1-Use getWindowHandles to store all the pages id as Set
            2-Loop through all pages and switch
            3-Break the look when title is what I am looking for.

      NOTE: GetWindowHandle-->Return String with single page ID
            GetWindowHandles-->Returns Set<String> with all unique page Ids

    20-How do you scroll down-up in Web Browsers during automation?
        ****-I mostly use JS scrollIntoView script.(I store it in my Browser Utils for any time usage)
        -actions.scrollByAmount(x,y)
        -Keys.PageUp or Down
        -Keys.ArrowUp or Down

    21-How do you upload file in Selenium?
        First of all, you need to find the location of CHOOSE Button
        Find the path of the file that you are going to attach(//C:Users//usa.png)
        Then send the keys of location to the choose button

    22-What is difference between Assert and SoftAssert?
        Assert is a class that have some methods to validate actual and expected data.
            Assert.assertEquals, assertTrue
            *When it fails, it throws exception right away and do not execute the next line of code.
        SoftAssert is a class that have some methods to validate actual and expected data.
            *We need to create an object
            SoftAssert softAssert = new SoftAssert();
            *When it fails, it doesn't throw exception then it keeps executing the next codes.
            *You must use Assert.all() to make it work property otherwise it will pass all the time.

    23-Can you tell me about your Singleton Pattern design? --> Can you make the constructor private, static final?
        First of all, I appreciate for this question since I like singleton logic because in the past I was working on
        my driver and getting lots of NULLPOINTER exception. With the help of Singleton, I centralize my driver which
        reduces the amount of exception I got whcich means it is more reliable and safe to use.
            -->I basically Encapsulated my Singleton:
                -I need to have Private WebDriver
                -I need to have Private Constructor
                -Put if condition to check me driver is null or not
                -Create a public method to call it from other classes

    24-What kind of TestNG annotation do you use in your project? Can you tell me What is the purpose of @Parameter usage?
        Please check the sublime -> It is explained in details recently

    25-What do you know about @DataProvide and why do you use it?
        Please check the sublime -> It is explained in details recently

    26-What do you know about Wait Times and can you tell me the difference between Thread.sleep, implicitly, explicitly, Fluent wait?
        Please check the sublime -> It is explained in details recently

     */
}
