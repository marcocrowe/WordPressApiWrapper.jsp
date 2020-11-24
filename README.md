# WordPressApiWrapper.jsp: WordPress API Wrapper Web Application 

## Setup Instructions

You must create a application.config file with two entries
1. apiUrl Is the URL of your Wordpress web app.
1. authorizationBearerToken is a BearerToken generated to allow access to your wordpress account

### Example entry:

```
apiUrl=http://server:port/wordpress/wp-json/wp/v2/posts/
authorizationBearerToken=0123456789abcde0123456789abcde
```
