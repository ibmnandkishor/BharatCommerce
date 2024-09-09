
        document.addEventListener("DOMContentLoaded", function() {
            const slides = document.querySelectorAll('.slide-container');
            const totalSlides = slides.length;
            let currentSlide = 0;
            const slideInterval = 3000; // Time between slides in milliseconds
        
            function goToSlide(slideIndex) {
                document.getElementById(`img-${slideIndex + 1}`).checked = true;
            }
        
            function nextSlide() {
                currentSlide = (currentSlide + 1) % totalSlides;
                goToSlide(currentSlide);
            }
        
            setInterval(nextSlide, slideInterval);
        });
        
  