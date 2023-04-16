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

    driver.find_element(By.LINK_TEXT, "Contact").click()
    driver.find_element(By.ID, "wpforms-8-field_0").send_keys("Asha Anna Thomas")
    driver.find_element(By.ID, "wpforms-8-field_1").send_keys("ashaanna88@gmail.com")
    driver.find_element(By.ID, "wpforms-8-field_2").send_keys("Test Message for Automation In Python")

    driver.find_element(By.NAME, "wpforms[submit]").click()

    message = driver.find_element(By.ID, "wpforms-confirmation-8").text

    print(message)

    assert message == "Thanks for contacting us! We will be in touch with you shortly."

    driver.close()