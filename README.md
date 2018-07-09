# RecyclerViewExample
This is an example of recycler view implementation with a custom interface to communicate with the activity.
The first example (package: RecyclerViewExample) sets on click listener item inside onBindViewHolder 
The issue with this implementation is that we are creating a new on click listener object everytime the 
user is swiping the list up and down. 

Second example utilizes the view holder implementation to set on click listener (RecyclerViewExample2)
Both activities implements the same functionality with different approach for item click listener design.

