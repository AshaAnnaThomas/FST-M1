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

    sec_Pop_Course_ele= driver.find_element(By.CSS_SELECTOR, "#post-71 .entry-title")

    sec_Pop_Course_text = sec_Pop_Course_ele.text

    print(sec_Pop_Course_text)

    assert sec_Pop_Course_text == "Email Marketing Strategies"

    driver.close()