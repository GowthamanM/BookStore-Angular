const resemble = require('resemblejs');
const puppeteer = require('puppeteer');

(async () => {
  const browser = await puppeteer.launch();
  const page = await browser.newPage();
  await page.goto('http://localhost:4200/signup');
  await page.setViewport({
    width:1200,
    height:800,
  })
  await page.type('#email', 'user@iamneo.ai');
  await page.type('#username', 'user');
  await page.type('#mobilenumber', '9087654321');
  await page.type('#password', 'user');
  await page.type('#confirmpassword','user');
  await page.click('#submitButton');
  await page.screenshot({path: 'exampleSign.png'});
  try {
    await page.waitForSelector('#loginBox',{timeout:1000});
    console.log('TESTCASE:test_case1:success');
  } catch {
    console.log('TESTCASE:test_case1:failure');
  }
  await page.close();
  await browser.close();

})();


(async () => {

    const browser = await puppeteer.launch();
    const page = await browser.newPage();
    await page.goto('http://localhost:4200/login');
    await page.setViewport({
      width:1200,
      height:800,
    })
    await page.type('#email', 'user@iamneo.ai');
    await page.type('#password', 'user');
    await page.click('#submitButton');
    await page.screenshot({path: 'example.png'});
    try {
      await page.waitForSelector('#navbar');
      console.log('TESTCASE:test_case2:success');
    } catch {
      console.log('TESTCASE:test_case2:failure');
    }
    await page.close();
    await browser.close();
  })();


  (async () => {

    const browser = await puppeteer.launch();
    const page = await browser.newPage();
    await page.goto('http://localhost:4200/login');
    await page.setViewport({
      width:1200,
      height:800,
    })
    await page.type('#email', 'admin');
    await page.type('#password', 'admin');
    await page.click('#submitButton');
    // await page.screenshot({path: 'example1.png'});
    try {
      await page.waitForSelector('#adminNavbar');
      console.log('TESTCASE:test_case3:success');
    } catch {
      console.log('TESTCASE:test_case3:failure');
    }
    await page.close();
    await browser.close();
  })();

  (async () => {

    const browser = await puppeteer.launch();
    const page = await browser.newPage();
    await page.goto('http://localhost:4200/login');
    await page.setViewport({
      width:1200,
      height:800,
    })
    await page.type('#email', 'user@iamneo.ai');
    await page.type('#password', 'user');
    await page.click('#submitButton');
    await page.waitForNavigation();
    
    try {
      await page.click("#cartButton");
      // await page.screenshot({path: 'example2.png'});
      await page.waitForSelector('#cartBody');
      console.log('TESTCASE:test_case4:success');
    } catch {
      console.log('TESTCASE:test_case4:failure');
    }
    await page.close();
    await browser.close();
  })();

  (async () => {

    const browser = await puppeteer.launch();
    const page = await browser.newPage();
    await page.goto('http://localhost:4200/login');
    await page.setViewport({
      width:1200,
      height:800,
    })
    await page.type('#email', 'user@iamneo.ai');
    await page.type('#password', 'user');
    await page.click('#submitButton');
    await page.waitForNavigation();
    
    try {
      await page.click("#orderButton");
      // await page.screenshot({path: 'example3.png'});
      await page.waitForSelector('#orderBody',{timeout:1000});
      console.log('TESTCASE:test_case5:success');
    } catch {
      console.log('TESTCASE:test_case5:failure');
    }
    await page.close();
    await browser.close();
  })();

  (async () => {

    const browser = await puppeteer.launch();
    const page = await browser.newPage();
    await page.goto('http://localhost:4200/login');
    await page.setViewport({
      width:1200,
      height:800,
    })
    await page.type('#email', 'user@iamneo.ai');
    await page.type('#password', 'user');
    await page.click('#submitButton');
    await page.waitForNavigation();
    
    try {
      await page.click("#logoutButton");
      // await page.screenshot({path: 'example4.png'});
      await page.waitForSelector('#loginBox',{timeout:1000});
      console.log('TESTCASE:test_case6:success');
    } catch {
      console.log('TESTCASE:test_case6:failure');
    }
    await page.close();
    await browser.close();
  })();