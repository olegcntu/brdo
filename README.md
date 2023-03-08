# brdo<br>
Implement the code in Spring Boot. Putting any git repository (gitLab, gitHub, Bitbucket) into public access.<br><br>

Minify data from https://dummyjson.com/comments, convert to array.<br>
Add a new updatedAt value in the format d-m-Y H:i:s (date and hour at the time of adding) to the skin object array.<br>
Modify username - use great letters.<br>
Save the array to the database users table (PostgreSql or MySQL), look like this:<br>

id | body | postId | username | updatedAt<br>
1 | This is some awesome thinking! | 100 | Eburras1q | 17-08-2022 21:30:50<br>
2 | What terrific math skills you're showing! | 27 | Omarsland1y | 17-08-2022 21:30:50<br>
…<br>
99 | …<br>
100 | …<br>
Save data on the html side (/users) for the help of Thymeleaf (you can cite a table or a grid), tag Bootstrap as a base template.<br>
Make the html side (/users) accessible only after authorization through Spring Security (optional, would be a plus)
