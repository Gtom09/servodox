<?php   
    require("./mailing/mailfunction.php");

    // Sanitize form inputs to prevent security issues (XSS, injections)
    $name = htmlspecialchars($_POST["name"]);
    $phone = htmlspecialchars($_POST['phone']);
    $email = filter_var($_POST["email"], FILTER_SANITIZE_EMAIL);  // Sanitize email
    $message = htmlspecialchars($_POST["message"]);

    // Validate email
    if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
        echo '<center><h1>Invalid email format. Please try again.</h1></center>';
        exit;  // Stop further processing
    }

    // Prepare the body of the email
    $body = "<ul>
                <li>Name: $name</li>
                <li>Phone: $phone</li>
                <li>Email: $email</li>
                <li>Message: $message</li>
             </ul>";

    // Add multiple recipients
    $recipient_email = "gebin092002@gmail.com, khankahan979@gmail.com";  // Multiple recipients

    // Call the mailfunction to send the email
    $status = mailfunction($recipient_email, "Company", $body);  // Send the email to the recipients

    // Display a confirmation message based on the result
    if ($status) {
        echo '<center><h1>Thanks! We will contact you soon.</h1></center>';
    } else {
        echo '<center><h1>Error sending message! Please try again.</h1></center>';
    }
?>
