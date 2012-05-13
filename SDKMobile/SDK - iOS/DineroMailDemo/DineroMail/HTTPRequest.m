#import "HTTPRequest.h" 
 
@implementation HTTPRequest 
 
@synthesize receivedData; 
@synthesize response; 
@synthesize result; 
@synthesize target; 
@synthesize selector; 
 
- (NSMutableURLRequest*)requestUrl:(NSString *)url bodyObject:(NSDictionary *)bodyObject 
{ 
    NSMutableURLRequest *request = [NSMutableURLRequest requestWithURL:[NSURL URLWithString:url] 
                                                           cachePolicy:NSURLRequestUseProtocolCachePolicy 
                                                       timeoutInterval:1.0f]; 
     
    [request setHTTPMethod:@"POST"]; 
     
    if(bodyObject) 
    { 
        NSMutableArray *parts = [NSMutableArray array]; 
        NSString *part; 
        id key; 
        id value; 
         
        for(key in bodyObject) 
        { 
            value = [bodyObject objectForKey:key]; 
            part = [NSString stringWithFormat:@"%@=%@", [key stringByAddingPercentEscapesUsingEncoding:NSUTF8StringEncoding], 
                                                        [value stringByAddingPercentEscapesUsingEncoding:NSUTF8StringEncoding]]; 
            [parts addObject:part]; 
        } 
         
        [request setHTTPBody:[[parts componentsJoinedByString:@"&"] dataUsingEncoding:NSUTF8StringEncoding]]; 
    }
     
    return request; 
} 
 
- (void)connection:(NSURLConnection *)connection didReceiveResponse:(NSURLResponse *)aResponse 
{ 
    self.response = aResponse; 
} 
 
- (void)connection:(NSURLConnection *)connection didReceiveData:(NSData *)data 
{ 
    [receivedData appendData:data]; 
} 
 
- (void)connection:(NSURLConnection *)connection didFailWithError:(NSError *)error 
{ 
	NSLog(@"Error: %@", [error localizedDescription]); 
} 
 
- (void)connectionDidFinishLoading:(NSURLConnection *)connection 
{ 
	result = [[NSString alloc] initWithData:receivedData encoding:NSUTF8StringEncoding]; 
     
	if(target) 
    { 
        [target performSelector:selector withObject:result]; 
    } 
} 
 
- (void)setDelegate:(id)aTarget selector:(SEL)aSelector 
{ 
	self.target = aTarget; 
    self.selector = aSelector; 
} 
 
- (void)dealloc 
{ 
    [receivedData release]; 
    [response release]; 
    [result release]; 
    [super dealloc]; 
} 
 
@end
