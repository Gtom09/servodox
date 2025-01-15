<?php

use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\SMTP;

require './vendor/autoload.php';
require 'mailingvariables.php';

function mailfunction($mail_reciever_email, $mail_reciever_name, $mail_msg, $attachment = false){

    $mail = new PHPMailer(true);  // Use true to enable exceptions for error handling
    try {
        // Set up PHPMailer to use SMTP
        $mail->isSMTP();

        // Enable SMTP debug output (uncomment this line for debugging)
        $mail->SMTPDebug = SMTP::DEBUG_SERVER;  // Show server responses

        // SMTP server settings
        $mail->Host = $GLOBALS['smtp.gmail.com'];  // e.g., 'smtp.gmail.com'
        $mail->Port = $GLOBALS['587'];  // Port number (587 for TLS, 465 for SSL)
        $mail->SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS;  // Use TLS encryption
        $mail->SMTPAuth = true;

        // SMTP authentication
        $mail->Username = $GLOBALS['gebintom'];  // Your email username
        $mail->Password = $GLOBALS['Gebintom@2002'];  // Your email password or app password

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
        // Catch any errors and return false
        echo 'Mailer Error: ' . $mail->ErrorInfo;  // Print the error message
        return false;
    }
}
?>
