# Project 3 - *Name of App Here*

**Name of your app** is a photo sharing app using Parse as its backend.

Time spent: **X** hours spent in total

## User Stories

The following **required** functionality is completed:

- [x] Style the login page to look like the real Instagram login page.
- [x] User can sign up to create a new account using Parse authentication
- [x] User can log in and log out of his or her account
- [x] The current signed in user is persisted across app restarts
- [x] User can take a photo, add a caption, and post it to "Instagram"
- [x] User can view the last 20 posts submitted to "Instagram"
- [x] User can pull to refresh the last 20 posts submitted to "Instagram"
- [x] User can tap a post to view post details, including timestamp and caption.

The following **optional** features are implemented:

- [x] Style the feed to look like the real Instagram feed.
- [ ] User should switch between different tabs - viewing all posts (feed view), capture (camera and photo gallery view) and profile tabs (posts made) using a Bottom Navigation View.
- [ ] User can load more posts once he or she reaches the bottom of the feed using infinite scrolling.
- [x] Show the username and creation time for each post
- [ ] After the user submits a new post, show an indeterminate progress bar while the post is being uploaded to Parse
- User Profiles:
   - [x] Allow the logged in user to add a profile photo
   - [x] Display the profile photo with each post
   - [ ] Tapping on a post's username or profile photo goes to that user's profile page
- [ ] User can comment on a post and see all comments for each post in the post details screen.
- [ ] User can like a post and see number of likes for each post in the post details screen.
- [ ] Create a custom Camera View on your phone.
- [ ] Run your app on your phone and use the camera to take the photo


The following **additional** features are implemented:

- [ ] List anything else that you can get done to improve the app functionality!
To improve the apps functionality I implemented the details page that wasn't listed as a requirement anymore and made the
home feed and main feed appear similar to the instagram one

Please list two areas of the assignment you'd like to **discuss further with your peers** during the next class (examples include better ways to implement something, how to extend your app in certain ways, etc):

1. Using queries
2. Getting special keys from Parse Objects

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<https://i.imgur.com/nv8Nfgh.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Credits

List an 3rd party libraries, icons, graphics, or other assets you used in your app.

- [Android Async Http Client](http://loopj.com/android-async-http/) - networking library


## Notes

Describe any challenges encountered while building the app.
Getting the right keys and Parse file properties proved challenging as well as getting the specific user's keys/properties to 
when there wasn't a direct Post object was difficulting. Using ParseUsers/objects as well as the Post class and the 
connection between both at times was confusing. 

## License

    Copyright [2018] [Nimo Hired]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.