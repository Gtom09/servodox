# Use the official PHP image with Apache
FROM php:8.1-apache

# Set the working directory inside the container
WORKDIR /var/www/html

# Install system dependencies and Composer
RUN apt-get update && apt-get install -y \
    curl \
    git \
    unzip \
    && curl -sS https://getcomposer.org/installer | php \
    && mv composer.phar /usr/local/bin/composer \
    && apt-get clean

# Copy the project files into the container
COPY . /var/www/html/

# Set file permissions (adjust based on your requirements)
RUN chown -R www-data:www-data /var/www/html \
    && chmod -R 755 /var/www/html

# Install PHP dependencies using Composer
RUN composer install --no-dev --optimize-autoloader

# Enable Apache mod_rewrite (optional but often necessary for routing)
RUN a2enmod rewrite

# Expose port 80 to access the application
EXPOSE 80

# Command to run Apache in the foreground
CMD ["apache2-foreground"]
