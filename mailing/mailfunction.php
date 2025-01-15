<?php

use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\SMTP;

require './vendor/autoload.php';
require 'mailingvariables.php';  // Make sure this path is correct and the file is configured as shown above.

function mailfunction($mail_reciever_email, $mail_reciever_name, $mail_msg, $attachment = false){

    $mail = new PHPMailer(true);  // PHPMailer with exception handling
    try {
        // Set up PHPMailer to use SMTP
        $mail->isSMTP(0);

        // Enable SMTP debug output (you can disable this once the issue is resolved)
        $mail->SMTPDebug = SMTP::DEBUG_SERVER;  // Show server responses

        // Set the SMTP server and port
        $mail->Host = $GLOBALS['mail_host'];  // Use the mail host from mailingvariables.php (e.g., 'smtp.gmail.com')
        $mail->Port = $GLOBALS['mail_port'];  // Use the port from mailingvariables.php (e.g., 587 for TLS)
        $mail->SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS;  // Use TLS encryption
        $mail->SMTPAuth = true;

        // SMTP authentication
        $mail->Username = $GLOBALS['mail_sender_email'];  // Your email address
        $mail->Password = $GLOBALS['mail_sender_password'];  // Your app password for Gmail

        // Set the "From" address
        $mail->setFrom($GLOBALS['mail_sender_email'], $GLOBALS['mail_sender_name']);

        // Add the recipient email address
        $mail->addAddress($mail_reciever_email, $mail_reciever_name);

        // Email subject
        $mail->Subject = 'Someone Contacted You!';

        // Set email format to HTML
        $mail->isHTML(true);
        $mail->msgHTML($mail_msg);  // HTML message body

        // Attach file if provided
        if ($attachment !== false) {
            $mail->AddAttachment($attachment);
        }

        // Alternative plain text body (for non-HTML email clients)
        $mail->AltBody = 'This is a plain-text message body';

        // Send the email and check if successful
        if ($mail->send()) {
            return true;
        } else {
            return false;
        }

    } catch (Exception $e) {
        // Catch any errors and print the error message
        echo 'Mailer Error: ' . $mail->ErrorInfo;  // Display the error message
        return false;
    }
}
?>
