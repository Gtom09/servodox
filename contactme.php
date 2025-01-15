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

    // Prepare the recipient emails (comma separated)
    $recipient_emails = "gebin092002@gmail.com;  // Multiple recipients

    // Set headers for email
    $headers = "From: $email\r\n";
    $headers .= "Reply-To: $email\r\n";
    $headers .= "MIME-Version: 1.0\r\n";
    $headers .= "Content-Type: text/html; charset=UTF-8\r\n";
    // Add the 'To' header manually if needed (optional here, as it's included in mail())
    $headers .= "To: $recipient_emails\r\n"; 

    // Call the mail function directly to send email
    $status = mail($recipient_emails, "Company", $body, $headers);  // Send the email to the recipients

    // Display a confirmation message based on the result
    if ($status) {
        echo '<center><h1>Thanks! We will contact you soon.</h1></center>';
    } else {
        echo '<center><h1>Error sending message! Please try again.</h1></center>';
    }
?>
