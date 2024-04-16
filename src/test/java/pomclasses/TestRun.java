package pomclasses;

// TODO Auto-generated method stub
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestRun {

public static void main(String[] args) throws InterruptedException {
		        // Set the path to chromedriver executable
		   

		        // Instantiate a ChromeDriver class
		        WebDriver driver = new ChromeDriver();

		        // Maximize the browser window
		        driver.manage().window().maximize();

		        // Set implicit wait time
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		

		        // Navigate to the specified URL
		        driver.get("https://staging.cymorg.com");

		        // Find and enter the Username field
		        WebElement usernameField = driver.findElement(By.id("username"));
		        usernameField.sendKeys("demotester7");

		        // Find and enter the Password field
		        WebElement passwordField = driver.findElement(By.id("password"));
		        passwordField.sendKeys("Cymorg@123");

		        // Find and click the Log In button
		        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Log In']"));
		        loginButton.click();

		        // Wait for the next page to load
		      

		        // Find and click the Restaurant button
		        WebElement restaurantButton = driver.findElement(By.xpath("//button[@title='Restaurant']"));
		        restaurantButton.click();

		        // Wait for the next page to load
		        
		        // Find and click the Start a new game button
		        WebElement newGameButton = driver.findElement(By.xpath("//button[normalize-space()='Start a new game']"));
		        newGameButton.click();
		        
		        driver.findElement(By.xpath("/html/body/div/div/main/div/div[2]/div[1]/div[1]/div/div/div/div/div[2]/button")).click();

		        // Wait for the next page to load
		        
		        // Find and click the Skip Intro button
		        WebElement skipIntroButton = driver.findElement(By.xpath("//button[normalize-space()='Skip Intro']"));
		        skipIntroButton.click();

		        // Wait for the next page to load
		     

		        // Find and click the Start Game button
		        WebElement startGameButton = driver.findElement(By.xpath("//button[normalize-space()='Start Game']"));
		        startGameButton.click();

		        // Wait for the next page to load
		        

		        // Click on the Next button four times
		        for (int i = 0; i < 4; i++) {
		            WebElement nextButton = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
		            nextButton.click();
		            // Wait for the next page to load
		          
		        }

		        // Find and click the Begin Game button
		        WebElement beginGameButton = driver.findElement(By.xpath("//button[normalize-space()='Begin Game']"));
		        beginGameButton.click();

		        // Wait for the next page to load
		      

		        // Find and click the Close button
		        WebElement closeButton = driver.findElement(By.xpath("//button[@title='Close']"));
		        closeButton.click();

		        // Wait for the next page to load
		       

		        // Find and click the Take Action button
		        WebElement takeActionButton = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div/div[2]/div/div[2]/div/div[2]/div[1]/button"));
		        takeActionButton.click();

		        // Wait for the next page to load
		      

		        // Find and click the RESPOND button
		        WebElement respondButton = driver.findElement(By.xpath("//div[normalize-space()='RESPOND']"));
		        respondButton.click();

		        // Wait for the next page to load
		    Thread.sleep(6000);
		    while(true) {
		        // Find and click the Type your message field
		        WebElement typeMessageField = driver.findElement(By.cssSelector("#chatbotInput"));
		        typeMessageField.sendKeys("Implementing a formal skill register in a restaurant setting can offer several advantages, making it a valuable tool for managing staff capabilities and improving overall operations. Firstly, a skill register allows for optimized workforce deployment. By maintaining a record of each staff member's skills and expertise, restaurant managers can assign tasks more efficiently. For example, if a chef excels in pastry making, they can be assigned dessert preparation tasks, leading to higher quality dishes and smoother operations during service. Secondly, a skill register facilitates targeted training and development. Managers can identify skill gaps among staff members and tailor training programs accordingly. This personalized approach not only enhances employee skills but also boosts morale and job satisfaction as employees feel supported in their growth and development within the organization. Additionally, a skill register aids in succession planning. Identifying potential successors for key roles based on their skills and readiness ensures smooth transitions during promotions or unexpected absences. This proactive approach helps maintain operational continuity and minimizes disruptions to the restaurant's workflow. Moreover, a skill register streamlines recruitment and onboarding processes. When hiring new staff, managers can match candidate skills with organizational needs, making informed hiring decisions. During onboarding, new employees can access the skill register to understand team dynamics and contribute effectively from the start. Implementing a skill register involves defining key skills, creating a user-friendly database, encouraging staff participation, and regularly updating and maintaining the register. Overcoming challenges such as data accuracy, privacy concerns, resistance to change, and integration with existing systems is essential for successful implementation. In conclusion, a skill register can significantly benefit a restaurant by optimizing workforce deployment, improving training and development, aiding in succession planning, streamlining recruitment and onboarding, and enhancing overall operational efficiency. By leveraging technology and fostering a culture of continuous learning, restaurants can harness the full potential of their staff and achieve long-term success in a competitive industry.");

		        // Find and click the Send button
		        WebElement sendButton = driver.findElement(By.xpath("//button[@title='Send']"));
		        sendButton.click();
		        
		        Thread.sleep(10000)
		        
		        ;
		        typeMessageField.sendKeys("Implementing a formal skill register in a restaurant setting can offer several advantages, making it a valuable tool for managing staff capabilities and improving overall operations. Firstly, a skill register allows for optimized workforce deployment. By maintaining a record of each staff member's skills and expertise, restaurant managers can assign tasks more efficiently. For example, if a chef excels in pastry making, they can be assigned dessert preparation tasks, leading to higher quality dishes and smoother operations during service. Secondly, a skill register facilitates targeted training and development. Managers can identify skill gaps among staff members and tailor training programs accordingly. This personalized approach not only enhances employee skills but also boosts morale and job satisfaction as employees feel supported in their growth and development within the organization. Additionally, a skill register aids in succession planning. Identifying potential successors for key roles based on their skills and readiness ensures smooth transitions during promotions or unexpected absences. This proactive approach helps maintain operational continuity and minimizes disruptions to the restaurant's workflow. Moreover, a skill register streamlines recruitment and onboarding processes. When hiring new staff, managers can match candidate skills with organizational needs, making informed hiring decisions. During onboarding, new employees can access the skill register to understand team dynamics and contribute effectively from the start. Implementing a skill register involves defining key skills, creating a user-friendly database, encouraging staff participation, and regularly updating and maintaining the register. Overcoming challenges such as data accuracy, privacy concerns, resistance to change, and integration with existing systems is essential for successful implementation. In conclusion, a skill register can significantly benefit a restaurant by optimizing workforce deployment, improving training and development, aiding in succession planning, streamlining recruitment and onboarding, and enhancing overall operational efficiency. By leveraging technology and fostering a culture of continuous learning, restaurants can harness the full potential of their staff and achieve long-term success in a competitive industry.");
		        sendButton.click();
		        Thread.sleep(10000);
		        
		        typeMessageField.sendKeys("Implementing a formal skill register in a restaurant setting offers numerous advantages, serving as a valuable tool for managing staff capabilities and enhancing overall operations. Initially, a skill register facilitates optimized workforce deployment by recording each staff member's skills and expertise. This allows restaurant managers to assign tasks more efficiently; for instance, a chef proficient in pastry making can be assigned dessert preparation tasks, leading to higher-quality dishes and smoother operations during service. Secondly, a skill register enables targeted training and development initiatives. Managers can identify skill gaps among staff members and tailor training programs accordingly, fostering employee growth and job satisfaction within the organization. Additionally, a skill register supports succession planning by identifying potential successors for key roles based on their skills and readiness, ensuring seamless transitions during promotions or unexpected absences and maintaining operational continuity. Moreover, a skill register streamlines recruitment and onboarding processes. Managers can match candidate skills with organizational needs, make informed hiring decisions, and enable new employees to understand team dynamics and contribute effectively from the start. Implementing a skill register involves defining key skills, creating a user-friendly database, encouraging staff participation, and regularly updating and maintaining the register. Overcoming challenges such as data accuracy, privacy concerns, resistance to change, and integration with existing systems is crucial for successful implementation. In conclusion, a skill register significantly benefits a restaurant by optimizing workforce deployment, improving training and development, aiding in succession planning, streamlining recruitment and onboarding, and enhancing overall operational efficiency. Through technological integration and a culture of continuous learning, restaurants can fully utilize their staff's potential and achieve sustained success in a competitive industry.");
		        sendButton.click();
Thread.sleep(10000);
typeMessageField.sendKeys( "Implementing a formal skill register in a restaurant setting provides several advantages, making it a valuable tool for managing staff capabilities and improving operations. Initially, the skill register allows for optimized workforce deployment by recording each staff member's skills and expertise. For example, if a chef is excellent at pastry making, they can be assigned dessert preparation tasks, leading to better-quality dishes and smoother operations during service. Secondly, the skill register supports targeted training and development. Managers can identify skill gaps among staff and tailor training programs accordingly, enhancing employee skills and boosting morale. Additionally, the register aids in succession planning by identifying potential successors for key roles based on skills and readiness, ensuring smooth transitions during promotions or absences. Moreover, it streamlines recruitment and onboarding processes by aligning candidate skills with organizational needs and facilitating new employees' understanding of team dynamics. Implementing a skill register involves defining key skills, creating a user-friendly database, encouraging staff participation, and regularly updating and maintaining it. Overcoming challenges such as data accuracy, privacy concerns, and integration with existing systems is crucial for successful implementation. In conclusion, a skill register significantly benefits a restaurant by optimizing workforce deployment, improving training, aiding in succession planning, streamlining recruitment, and enhancing overall efficiency.");
		        // Wait for the message to be sent
sendButton.click();
Thread.sleep(10000);

driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div/div[2]/div/div[3]/div/div/div[1]/button[2]")).click();
Thread.sleep(6000);

driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[3]/div/div/div[5]/button[2]")).click();
Thread.sleep(6000);

		        // Close the browser
//		        driver.quit();
		    }
}
		

	}
