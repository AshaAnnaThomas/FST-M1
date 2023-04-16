# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    driver.get("https://alchemy.hguy.co/lms")

    driver.find_element(By.LINK_TEXT, "My Account").click()

    pageTitle = driver.title

    print(pageTitle)

    assert pageTitle == "My Account – Alchemy LMS"
    
    driver.close()