//
//  LibTestAppDelegate.h
//  LibTest
//
//  Created on 9/12/11.
//  Copyright 2011 DineroMail. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface LibTestAppDelegate : NSObject <UIApplicationDelegate> {
    
    UIWindow *window;
    UINavigationController *navigationController;
}

@property (nonatomic, retain) IBOutlet UIWindow *window;
@property (nonatomic, retain) IBOutlet UINavigationController *navigationController;

@end

