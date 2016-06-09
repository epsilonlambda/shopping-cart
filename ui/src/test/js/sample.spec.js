/**
 * 
 * Created by Kirill on 6/9/2016.
 */

import Catalog from '../../main/js/components/catalog.js';

describe("description", () => {
    it("should pass", () => {
        expect(true).toBe(true);
        expect(Catalog).toBeDefined();
    });
    
    xit("should fail", () => {
        expect(1).toBe("cheese");
    });
});
