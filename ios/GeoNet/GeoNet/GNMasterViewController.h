//
//  GNMasterViewController.h
//  GeoNet
//
//  Created by Martin Goffan on 5/13/12.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>

@class GNDetailViewController;

@interface GNMasterViewController : UITableViewController

@property (strong, nonatomic) GNDetailViewController *detailViewController;

@end
