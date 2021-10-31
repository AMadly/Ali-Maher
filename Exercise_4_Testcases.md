#Testcases
Testcases were created to test the 'Product' APIs ,The testing was done for the GET,POST and DELETE requests:

#GET:
Can be found in GET_Testcases Class, included tests are:
1) CheckGetResponseSuccess-> Check on HTTP +ve response
2) CheckGetResponseFail -> Check on HTTP -ve response through using GET on a non existing ID
3) PostThenGetNewProductByID-> Check on HTTP +ve response when trying to GET a newly created Product
4) CheckGetIdContainsCorrectName-> Check that a correct product name exists in an already existing product
5) CheckGetIdWithIncorrectName-> Check that a correct product name Does NOT exist in an already existing product

#POST:
Can be found in POST_Testcases Class, included tests are:
1) CheckPostResponseSuccess-> Check on HTTP +ve response 
2) CheckPostResponseSuccessWhenRemoveOptionalParam-> Check on HTTP +ve response when sending POST request with missing optional
parameters
3) CheckPostResponseFailWhenRemoveMandatoryParam-> Check on HTTP -ve response when sending POST request with missing mandatory
parameters

#DELETE:
Can be found in DELETE_Testcases Class, included tests are:
1) PostThenDeleteNewProductByID-> Check that when creating a new product, it can be deleted succesfully
2) PostThenDeleteNewProductByIDx2> Check that when creating a new product, it can be deleted succesfully on first attempt
but on second DELETE request it returns 'Not Found' response