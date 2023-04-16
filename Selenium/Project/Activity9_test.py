# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.action_chains import ActionChains

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

    driver.find_element(By.LINK_TEXT, "Login").click()
    driver.find_element(By.ID, "user_login").send_keys("root")
    driver.find_element(By.ID, "user_pass").send_keys("pa$$w0rd")

    driver.find_element(By.NAME, "wp-submit").click()

    driver.find_element(By.CSS_SELECTOR, "#ld-course-list-item-69 .ld-course-title").click()
    socialMediaMarketingTitle = driver.title

    assert socialMediaMarketingTitle == "Social Media Marketing – Alchemy LMS"

    driver.find_element(By.CSS_SELECTOR, "#ld-expand-83 .ld-item-title").click()
    getCurrentUrl = driver.current_url

    assert getCurrentUrl == "https://alchemy.hguy.co/lms/lessons/developing-strategy/"

    value = False

    progressReader = driver.find_element(By.CSS_SELECTOR, ".ld-status").text

    if (progressReader == "IN PROGRESS"):
        driver.find_element(By.XPATH, "//input[@value='Mark Complete'])[2]").click()
        value = True
        driver.find_element(By.CSS_SELECTOR, ".ld-content-action:nth-child(3) .ld-text").click()
    elif (progressReader == "COMPLETE"):
        value = True
        driver.find_element(By.CSS_SELECTOR, ".ld-content-action:nth-child(3) .ld-text").click()

    print(driver.title)
    assert driver.title == "Monitoring & Digital Advertising – Alchemy LMS"
    print(driver.current_url)
    assert driver.current_url == "https://alchemy.hguy.co/lms/lessons/monitoring-digital-advertising/"

    driver.close()
