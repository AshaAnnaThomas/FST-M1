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

    driver.find_element(By.LINK_TEXT, "All Courses").click()

    pageTitle = driver.title
    print(pageTitle)

    assert  pageTitle == "All Courses – Alchemy LMS"

    elements = driver.find_elements(By.CSS_SELECTOR, ".entry-title")

    print(len(elements))

    assert 3 == len(elements)

    for x in range (len(elements)):
        print(elements[x].text)

    assert elements[0].text == "Social Media Marketing"
    assert elements[1].text == "Email Marketing Strategies"
    assert elements[2].text == "Content Marketing"

    driver.close()